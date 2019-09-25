#如果存在test存储过程则删除
#创建无参存储过程,名称为test
drop procedure if exists test_procedure;
create procedure test_procedure()
begin
    #声明变量 #变量赋值 set i = 0;
    declare i int default 0;
    while i < 100 do
    insert into test values(i,concat('tom',i));
    set i = i+1;
    end while; #结束while循环
end; #结束定义语句
#调用存储过程
call test_procedure();

select * from test
