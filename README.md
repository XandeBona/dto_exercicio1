banco de dados


create table aluno (
	id int auto_increment primary key,
    nome text,
    matricula text,
    id_turma int,
    FOREIGN KEY (id_turma) references turma(id)
);
 
create table professor (
	id int auto_increment primary key,
    nome text,
    data_nascimento date
);
 
create table turma (
	id int auto_increment primary key,
    nome_turma text
);
 
create table professor_turma (
	id int auto_increment primary key,
    id_professor int,
    id_turma int,
    FOREIGN KEY (id_professor) references professor(id),
    FOREIGN KEY (id_turma) references turma(id)
);

