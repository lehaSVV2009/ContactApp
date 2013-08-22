drop table if exists contact;

create table contact(
  id int not null auto_increment
  , first_name varchar(60) not null
  , last_name varchar(40) not null
  , birth_date date
  , description varchar(2000)
  , photo blob
  , version int not null default 0
  , unique uq_contact_1 (first_name, last_name)
  , primary key (id)

);