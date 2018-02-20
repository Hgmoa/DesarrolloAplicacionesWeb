package daw.spring.service;

import daw.spring.model.Roles;
import daw.spring.model.User;
import daw.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User findOneById(Long id) {
        return userRepository.findOne(id);
    }


    public User findOneUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


    @PostConstruct
    public void init() {

        User user1 = new User("Amador", "Rivas", "amador@merengue.com", encoder.encode("1234"), null, "9866363", null, null, Roles.USER);
        saveUser(user1);
        User user2 = new User("Teodoro", "Rivas", "teodor69@merengue.com", encoder.encode("1234"), null, "9866363", null, null, Roles.USER);
        saveUser(user2);

        User userAdmin1 = new User("Admin", "Root", "admin@admin.com", encoder.encode("1234"), null, "9866363", null, null, Roles.ADMIN);
        saveUser(userAdmin1);

        User user3 = new User("ramon", "serrano", "ramon@ramon.com", encoder.encode("1234"), null, "9866363", null, null, Roles.USER);
        saveUser(user3);
        User user4 = new User("dani", "maci", "dani@maci.com", encoder.encode("1234"), null, "9866363", null, null, Roles.USER);
        saveUser(user4);

        User user5 = new User("Hugo", "Santana", "hugo@santana.com", encoder.encode("1234"), null, "9866363", null, null, Roles.USER);
        saveUser(user5);

        User user6 = new User("Jorge", "Bicho", "Jorge@gmail.com", encoder.encode("1234"), null, "9866363", null, null, Roles.USER);
        saveUser(user6);

        /*

         ('alicia', 'rodriguez', 'alicia@gmail.com', 'c/murcia', 12345, '', '')
         ('aberto', 'serrano', 'ramon@ramon.com', 'c/miami', 12345, '', '')
         ('Michael', 'Gallego', 'mic@gmail.com', 'c/frackfurt', 12345, '', '')
         ('Patxi', 'lopez', 'patxi@gmail.com', 'c/berlin', 12345, '', '')
         ('cristina', 'garcia', 'cristina@gmail.com', 'c/miraflor', 12345, '', '')
         ('ana', 'serrano', 'aba@gmail.com', 'c/conde', 12345, '', '')
         ('maria', 'serrano', 'maria@gmail.com', 'c/zorron', 12345, '', '')
         ('antonia', 'serrano', 'antonia@gmail.com', 'c/mira que si voy', 12345, '', '')
         ('fidel', 'castro', 'fidel@gmail.com', 'c/genocida', 12345, '', '')
         ('Santiago ', 'Barnabeu', 'satiago@gmail.com', 'c/estadio', 12345, '', '')
         ('Cristiano', 'Ronaldo', 'cristianao@gmail.com', 'c/abdominal', 12345, '', '')
         ('Raul', 'Blanco', 'raul@gmail.com', 'c/burbuja', 12345, '', '')
        ('Florentino', 'Perez', 'titofloren@gmail.com', 'c/ricachoes', 12345, '', '')
         ('Valentino', 'Rossi', 'vale46@gmail.com', 'c/italia', 12345, '', '')
         ('Marc', 'Marquez', 'marc@gmail.com', 'c/honda', 12345, '', '')}
         */

    }


}
