```
mysql -uroot -p

à distance:
mysql -h192.168.200.128 -P3306 -uroot -p
```
# manipulation syntax
    
show databases;

select database();

use nameOfdatabase;

create database [if not exists]  nameOfdatabase [default charset utf8mb4];