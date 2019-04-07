-- Krijimi i tabelave ne SQL

drop database if exists Yahtzee;
create database Yahtzee;
use Yahtzee;

create table Player_Profile (
pId integer, 
username varchar(25), 
email varchar(50) not null, 
password varchar(20) not null, 
birthdate date not null, 
country varchar(30) not null, 
registration_date datetime not null, 
avatar BLOB, 
primary key (pId));


create table Friends (
pId integer, 
FriendId integer
primary key (pId,FriendId),
foreign key (pId) references Player_Profile(pId) on delete cascade on update cascade,
foreign key (FriendId) references Player_Profile(pId) on delete cascade on update cascade);



create table Request_For_Friends (
requestId integer, 
pid integer not null, 
Date_Request datetime not null, 
FriendId integer not null, 
Accepted boolean,
primary key (requestId),
foreign key (pId) references Player_Profile(pId) on delete cascade on update cascade,
foreign key (FriendId) references Player_Profile(pId) on delete cascade on update cascade);


create table Game_History (
ghId integer, 
startTime datetime not null, 
endTime datetime not null,
primary key (ghId));


create table Game_History_Details (
ghId integer, 
pid integer, 
total_points integer not null, 
game_won boolean ,
primary key (ghId,pid),
foreign key (ghId) references Game_History(ghId) on delete cascade on update cascade),
foreign key (pId) references Player_Profile(pId) on delete cascade on update cascade));


create table Player_Stats (
psId integer,
pId integer not null, 
games_played integer not null, 
games_won integer not null, 
wins_streak integer not null, 
total_points integer not null, 
average_points double not null, 
rank varchar(25) not null,
primary key (psId),
foreign key (pId) references Player_Profile(pId) on delete cascade on update cascade);


