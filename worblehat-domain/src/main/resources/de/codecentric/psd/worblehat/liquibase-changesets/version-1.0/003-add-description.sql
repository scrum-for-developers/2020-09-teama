-- liquibase formatted sql


-- changeset action:add description
ALTER TABLE book ADD COLUMN description varchar(255);