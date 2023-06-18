create table tbl_account (id UUID not null,
created_date timestamp,
numero varchar(255),
titular varchar(255),
primary key (id));

create table tbl_account_transference (id UUID not null,
created_date timestamp,
appointment_date timestamp,
max_days_per_tax integer not null,
max_value_peer_tax numeric(19,2),
tax_percent numeric(19,2),
tax_value numeric(19,2),
value_transference numeric(19,2),
account_destiny UUID,
account_origin UUID,
primary key (id));

INSERT INTO tbl_account(id, titular, numero, created_date)
VALUES('79ceb126-1b38-4cfc-89ff-ffe1cb08ed94', 'Rafael', '00001', {ts '2022-12-01 18:47:52.69'});

INSERT INTO tbl_account(id, titular, numero, created_date)
VALUES('b465ecf5-b97a-4ed5-bedb-cf4af9ae55ac', 'Gilbert', '00002', {ts '2022-12-01 18:47:52.69'});

INSERT INTO tbl_account(id, titular, numero, created_date)
VALUES('c1991162-5e04-4550-b271-cf3bbe44dff1', 'Claudio', '00003', {ts '2022-12-01 18:47:52.69'});

INSERT INTO tbl_account(id, titular, numero, created_date)
VALUES('a021b94a-06d6-477c-bec9-a8237bf94ece', 'Fabricio', '00004', {ts '2022-12-01 18:47:52.69'});

INSERT INTO tbl_account_transference(id,
account_destiny,
account_origin,
value_transference,
tax_value,
tax_percent,
max_value_peer_tax,
max_days_per_tax,
appointment_date,
created_date)
VALUES('28a58809-8bf8-4f63-8f7f-318cb4ea52c2',
'79ceb126-1b38-4cfc-89ff-ffe1cb08ed94', -- account destiny
'b465ecf5-b97a-4ed5-bedb-cf4af9ae55ac', -- account origin
500.0, -- value
3, -- tax value
3, -- tax percentual
1000, -- max value peer tax
1, -- max days per tax
{ts '2023-06-02 18:47:52.69'},
{ts '2022-12-01 18:47:52.69'});

INSERT INTO tbl_account_transference(id,
account_destiny,
account_origin,
value_transference,
tax_value,
tax_percent,
max_value_peer_tax,
max_days_per_tax,
appointment_date,
created_date)
VALUES('a27e7fd6-a7be-451f-9dac-8c665325f26a',
'b465ecf5-b97a-4ed5-bedb-cf4af9ae55ac', -- account destiny
'79ceb126-1b38-4cfc-89ff-ffe1cb08ed94', -- account origin
700.0, -- value
3, -- tax value
3, -- tax percentual
1000, -- max value peer tax
1, -- max days per tax
{ts '2023-06-02 18:47:52.69'},
{ts '2022-12-01 18:47:52.69'});

alter table tbl_account_transference add constraint FKt5g6lx8spiovpdefs5t437jq5 foreign key (account_destiny) references tbl_account;
alter table tbl_account_transference add constraint FK3xt8awh02kujiibacl2t4si89 foreign key (account_origin) references tbl_account;

