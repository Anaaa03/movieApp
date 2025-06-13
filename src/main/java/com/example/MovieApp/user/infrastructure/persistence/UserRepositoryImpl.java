package com.example.MovieApp.infrastructure.persistence.user;

import com.example.MovieApp.user.domain.Email;
import com.example.MovieApp.user.domain.User;
import com.example.MovieApp.user.domain.UserId;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository repository;

    public UserRepositoryImpl(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        UserEntity entity = new UserEntity(
                null,
                user.getUsername(),
                user.getEmail().getValue(),
                user.getPasswordHash(),
                Instant.now(),
                user.isActive()
        );
        repository.save(entity);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return repository.findById(id.getValue().getMostSignificantBits())
                .map(this::toDomain);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return repository.findByEmail(email.getValue())
                .map(this::toDomain);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return repository.existsByEmail(email.getValue());
    }

    private User toDomain(UserEntity entity) {
        return new User(
                new UserId(UUID.randomUUID()), // możesz zaadaptować sposób generowania UUID
                entity.getUsername(),
                new Email(entity.getEmail()),
                entity.getPasswordHash()
        );
    }
}
