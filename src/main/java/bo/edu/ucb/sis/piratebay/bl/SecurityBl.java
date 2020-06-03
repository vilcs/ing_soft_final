package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class SecurityBl {

    private UserDao userDao;

    @Value("${piratebay.security.salt}")
    private String salt;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Este metodo recibe el usuario y password en plano, consulta a la base de datos, enviando el password con
     * SHA256 + SALT, y si esta bien genera el token JWT
     * @param username Nombre de usuario en plano
     * @param password Contraseña en plano
     * @return Token JWT.
     */
    public String authenticate(String username, String password) {
        String sha256hex = Hashing.sha256()
                .hashString(password+salt, StandardCharsets.UTF_8)
                .toString(); // TODO Repetir el algoritmo de hash N veces
        Integer userId = userDao.findUserIdByUsernameAndPassword(username, sha256hex);
        if (userId != null ) {
            return generateJWT(userId);
        } else {
            return null;
        }
    }

    private String generateJWT(Integer userId) {
        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(2);
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretJwt);
            token = JWT.create()
                    .withIssuer("PirateBay")
                    .withSubject(userId.toString())
                    .withExpiresAt(Date.from(expiresAt.toInstant(ZoneOffset.of("+04:00")))) // TODO corregir fecha
                    .sign(algorithm);
        } catch (JWTCreationException ex){
            throw new RuntimeException(ex);
        }
        return token;
    }
}
