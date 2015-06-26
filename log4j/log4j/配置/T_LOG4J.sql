prompt PL/SQL Developer import file
prompt Created on 2008��3��3�� by Administrator
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
  is '��ˮ��';
comment on column T_LOG4J.STAMP
  is 'ʱ��';
comment on column T_LOG4J.THREAD
  is '��ǰ�߳�';
comment on column T_LOG4J.INFOLEVEL
  is '��ǰ����';
comment on column T_LOG4J.CLASS
  is '��ǰjava����-����';
comment on column T_LOG4J.MESSAGES
  is '��ǰ�����Ϣ';

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
