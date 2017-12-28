
drop table if exists Projects;
create table Projects
(
    id varchar(50) not null comment '标识',
    name varchar(100) not null comment '项目名称',
    Description text null comment '项目描述',
    primary key(id)
)comment='项目资料表' collate='utf8_general_ci' engine=InnoDB;

drop table if exists ProjectModels;
create table ProjectModels
(
    id varchar(50) not null comment '标识',
    project_id varchar(50) not null comment '项目标识',
    name varchar(100) not null comment '模块名称',
    parent varchar(50) null comment '上级模块',
    Description text null comment '模块描述',
    primary key(id),
    unique index(project_id,name)
)comment='项目资料表' collate='utf8_general_ci' engine=InnoDB;


drop table if exists Apis;
create table Apis
(
    id varchar(50) not null comment '标识',
    project_id varchar(50) not null comment '项目标识',
    name varchar(255) not null comment '接口名称',
    Url varchar(255) not null comment '接口地址',
    model_id varchar(50) null comment '所属模块',
    Protocol varchar(10) null comment '协议',
    Produces varchar(100) null comment '请求格式',
    Consumes varchar(100) null comment '响应格式',
    Method varchar(10) null comment '请求方法',
    Version varchar(20) null comment '接口版本号',
    Status tinyint default 0 null comment '接口状态,0 已上线，1 开发中',
    Description text null comment '接口描述',
    primary key(id)
)comment='接口资料表' collate='utf8_general_ci' engine=InnoDB;

drop table if exists ApiRequests;
create table ApiRequests
(
    id varchar(50) not null comment '标识',
    api_id varchar(50) not null comment '接口标识',
    parent varchar(50) null comment '上级标识',
    Parameter varchar(100) not null comment '参数',
    DataType varchar(100) not null comment '数据类型,String,Number,Json',
    PartType varchar(100) not null comment '参数位置,query,formData,body',
    Required tinyint null default 0 comment '是否必需,0否，1是',
    Length varchar(10) null default '-' comment '数据最大长度',
    Description text null comment '描述',
    Example text null comment '示例',
    primary key(id),
    unique index(api_id,Parameter)
)comment='接口请求参数' collate='utf8_general_ci' engine=InnoDB;


drop table if exists ApiRequestExamples;
create table ApiRequestExamples
(
    id varchar(50) not null comment '标识',
    api_id varchar(50) not null comment '接口标识',
    Tag varchar(100) not null comment '标签',
    Content text null comment '内容',
    primary key(id),
    unique(api_id,Tag)
)comment='接口请求参数示例' collate='utf8_general_ci' engine=InnoDB;

drop table if exists ApiResponses;
create table ApiResponses
(
    id varchar(50) not null comment '标识',
    api_id varchar(50) not null comment '接口标识',
    parent varchar(50) null comment '上级标识',
    Parameter varchar(100) not null comment '参数',
    DataType varchar(100) not null comment '数据类型,String,Number,Json',
    PartType varchar(100) not null comment '参数位置,query,formData,body',
    Required tinyint null default 0 comment '是否必需,0否，1是',
    Length varchar(10) null default '-' comment '数据最大长度',
    Description text null comment '描述',
    Example text null comment '示例',
    primary key(id),
    unique index(api_id,Parameter)
)comment='接口响应参数' collate='utf8_general_ci' engine=InnoDB;

drop table if exists ApiResponseExamples;
create table ApiResponseExamples
(
    id varchar(50) not null comment '标识',
    api_id varchar(50) not null comment '接口标识',
    Tag varchar(100) not null comment '标签',
    Content text null comment '内容',
    primary key(id),
    unique(api_id,Tag)
)comment='接口响应参数示例' collate='utf8_general_ci' engine=InnoDB;

drop table if exists ApiExceptionExamples;
create table ApiExceptionExamples
(
    id varchar(50) not null comment '标识',
    api_id varchar(50) not null comment '接口标识',
    Tag varchar(100) not null comment '标签',
    Content text null comment '内容',
    primary key(id),
    unique(api_id,Tag)
)comment='接口错误示例' collate='utf8_general_ci' engine=InnoDB;

drop table if exists ApiExceptionCodes;
create table ApiExceptionCodes
(
    id varchar(50) not null comment '标识',
    api_id varchar(50) not null comment '接口标识',
    code varchar(10) not null comment '响应代码',
    Description text null comment '描述',
    Solution text null comment '解决方案',
    primary key(id),
    unique index(api_id,code)
)comment='接口错误代码描述' collate='utf8_general_ci' engine=InnoDB;