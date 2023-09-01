create table answers(
    exp_id int not null comment '实验id也是本用户的第几次实验',
    question_id int not null comment '作答顺序',
    user_id bigint(20) not null ,
    answer varchar(255) comment '作答内容',
    id varchar(32) comment '页面id',
    next_id varchar(32) comment '下一页id',
    primary key(exp_id,question_id,user_id)
)character set utf8 comment '作答记录';

create table experiment(
    exp_id int not null comment '实验id也是本用户的第几次实验',
    user_id bigint(20) not null,
    status bit(1) comment '0未完成，1已提交',
    Objective_score DECIMAL(4,1) comment '客观题总分',
    Subjective_score DECIMAL(4,1) comment '主观题总分',
    start_time datetime comment '开始时间',
    end_time datetime comment '结束时间',
    PRIMARY KEY (exp_id,user_id)
)comment '实验表';

create table schedule(
    exp_id int not null,
    user_id bigint(20) not null,
    status bit(1) comment '0未完成，1已提交',
    Objective_score DECIMAL(4,1) comment '客观题总分',
    Subjective_score DECIMAL(4,1) comment '主观题总分',
    id varchar(32) comment '页面id',
    next_id varchar(32) comment '下一页id',
    start_time datetime,
    end_time datetime,
    primary key(exp_id,user_id)
)comment '演练进度';

create table Score(
    id varchar(32) comment '页面id',
    answer varchar(255) comment '标准答案',
    type int comment '题目类型',
    score DECIMAL(4,1) comment '答案分数'
);

# create table page_info(
#     page_info_id bigint auto_increment,
#     FriendBodyString varchar(255),
#     PayWay varchar(255),
#     controlNumber int,
#     friendNumber int,
#     friendsing int,
#     isPlaying boolean,
#     randomString varchar(255),
#     workString varchar(255),
#     worksing int,
#     primary key (page_info_id)
# )comment '页面信息-用于完成继续实验的跳转功能';

# 使得experiment表在插入新数据时，每个用户自己的exp_id自增
DELIMITER //
CREATE TRIGGER set_increment_exp_id BEFORE INSERT ON experiment
    FOR EACH ROW
BEGIN
    DECLARE max_exp_id INT;
    SET max_exp_id = (SELECT MAX(exp_id) FROM experiment WHERE user_id = NEW.user_id);
    IF max_exp_id IS NULL THEN
        SET NEW.exp_id = 1;
    ELSE
        SET NEW.exp_id = max_exp_id + 1;
    END IF;
END;
//
DELIMITER ;

# 在插入新记录后，首先检查新记录中的 score 是否不为空（NULL）。
# # 如果 score 不为空，那么就执行一个 UPDATE 语句来将 experiment 表中对应实验和用户的总分加上新记录中的 score。
# DELIMITER //
#
# CREATE TRIGGER update_sum_score
#     AFTER INSERT ON answers
#     FOR EACH ROW
# BEGIN
#     IF NEW.score IS NOT NULL THEN
#         UPDATE experiment
#         SET sum_score = sum_score + NEW.score
#         WHERE exp_id = NEW.exp_id AND user_id = NEW.user_id;
#     END IF;
# END;
# //
# DELIMITER ;


# 当作答记录插入时，更新进度表的实验总分
DELIMITER //

CREATE TRIGGER sync_experiment_score
    AFTER UPDATE ON experiment
    FOR EACH ROW
BEGIN
    UPDATE schedule
    SET Objective_Score = NEW.Objective_score,
        Subjective_Score = NEW.Subjective_score
    WHERE exp_id = NEW.exp_id AND user_id = NEW.user_id;
END//

DELIMITER ;





# 在插入新记录前，查询当前用户在特定实验（由插入操作中的 exp_id 决定）下的最大 question_id。
# 如果没有记录，则将 question_id 设置为 1，否则将其增加 1。
DELIMITER //

CREATE TRIGGER set_increment_question_id BEFORE INSERT ON answers
    FOR EACH ROW
BEGIN
    DECLARE max_question_id INT;

    -- Get the maximum question_id for the user and exp_id
    SET max_question_id = (SELECT MAX(question_id) FROM answers WHERE user_id = NEW.user_id AND exp_id = NEW.exp_id);

    -- If there are no existing records for the user and exp_id, set question_id to 1
    IF max_question_id IS NULL THEN
        SET NEW.question_id = 1;
    ELSE
        SET NEW.question_id = max_question_id + 1;
    END IF;

END;
//

DELIMITER ;

# 提交新作答后记录最新的页面id和下一页id用于继续演练的功能
DELIMITER //
CREATE TRIGGER insert_schedule AFTER INSERT ON answers
    FOR EACH ROW
BEGIN
    UPDATE schedule SET id = NEW.id, next_id = NEW.next_id
    WHERE exp_id = NEW.exp_id AND user_id = NEW.user_id;
END;
//
DELIMITER ;




