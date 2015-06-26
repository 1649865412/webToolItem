prompt PL/SQL Developer import file
prompt Created on 2008年3月3日 by Administrator
set feedback off
set define off
prompt Creating T_LOG4J...
create table T_LOG4J
(
  GUID      NUMBER,
  STAMP     VARCHAR2(20),
  THREAD    VARCHAR2(20),
  INFOLEVEL VARCHAR2(10),
  CLASS     VARCHAR2(255),
  MESSAGES  VARCHAR2(1024)
)
;
comment on column T_LOG4J.GUID
  is '流水号';
comment on column T_LOG4J.STAMP
  is '时间';
comment on column T_LOG4J.THREAD
  is '当前线程';
comment on column T_LOG4J.INFOLEVEL
  is '当前级别';
comment on column T_LOG4J.CLASS
  is '当前java程序-方法';
comment on column T_LOG4J.MESSAGES
  is '当前输出信息';

prompt Disabling triggers for T_LOG4J...
alter table T_LOG4J disable all triggers;
prompt Truncating T_LOG4J...
truncate table T_LOG4J;
prompt Loading T_LOG4J...
prompt Table is empty
prompt Enabling triggers for T_LOG4J...
alter table T_LOG4J enable all triggers;
set feedback on
set define on
prompt Done.
