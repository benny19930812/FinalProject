

CREATE TABLE  MVCMember (
	PK	   	    	INT GENERATED as IDENTITY,
	account 		varchar(32), 
	password 		varchar(32), 
	name 			varchar(32), 
	phone  			varchar(15), 
	birthday  		date, 	
	registerDate  	date, 	
	weight 			Numeric(6,2), 
	primary key(PK)
);   


    
CREATE TABLE  Member42 (
  memberId   	  varchar(32) Primary Key ,
  password   	  varchar(32),
  name            varchar(32),
  address         varchar(64),
  phone           varchar(15),
  birthday        date,
  registerdate 	  date,
  picture         clob,
  weight          number   
);      

INSERT INTO Member42 (memberId, password, name, address, phone, birthday,  registerdate, weight)
values ('micky', '123', '米小薯', '台中市文心南路三段５８巷２２０號', '04-67891234', TO_DATE('1975-02-17','yyyy-mm-dd'), to_date(sysdate), 60);

-- select * from Member42;
