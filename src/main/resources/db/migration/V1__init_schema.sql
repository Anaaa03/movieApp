CREATE TYPE gender_enum AS ENUM (
    'female',
    'male',
    'prefer_not_to_say'
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       avatar_url TEXT,
                       gender gender_enum,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE movies (
                        id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        release_year INT,
                        duration_minutes INT,
                        description TEXT,
                        poster_url TEXT,
                        trailer_url TEXT,
                        age_rating VARCHAR(10)
);


CREATE TABLE genres (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE filmgenres (
                            movie_id INT NOT NULL,
                            genre_id INT NOT NULL,
                            PRIMARY KEY (movie_id, genre_id),
                            FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
                            FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);

CREATE TABLE reviews (
                         id SERIAL PRIMARY KEY,
                         user_id INT NOT NULL,
                         movie_id INT NOT NULL,
                         rating INT NOT NULL CHECK (rating BETWEEN 1 AND 10),
                         title VARCHAR(255),
                         content TEXT NOT NULL,
                         review_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                         UNIQUE (user_id, movie_id),
                         FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                         FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);


CREATE TABLE forum_threads (
                               id SERIAL PRIMARY KEY,
                               movie_id INT NOT NULL,
                               user_id INT NOT NULL,
                               title VARCHAR(255) NOT NULL,
                               created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
                               FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE forum_posts (
                             id SERIAL PRIMARY KEY,
                             thread_id INT NOT NULL,
                             user_id INT NOT NULL,
                             content TEXT NOT NULL,
                             created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                             likes INT DEFAULT 0,
                             dislikes INT DEFAULT 0,
                             FOREIGN KEY (thread_id) REFERENCES forum_threads(id) ON DELETE CASCADE,
                             FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
