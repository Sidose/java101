--liquibase formatted sql
--changeset ssydorenko:create-roles-table
CREATE TABLE user_role (
  id_user BIGINT NOT NULL,
  id_role BIGINT NOT NULL,

  FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (id_role) REFERENCES roles(id) ON DELETE CASCADE
) ENGINE=InnoDB;

--rollback DROP TABLE roles;
