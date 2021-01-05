create table acs_user (id bigint not null, created_date timestamp, email varchar(255), is_active boolean not null, last_login_date timestamp, mobile varchar(255), name varchar(255), password varchar(255), role varchar(255), username varchar(255), primary key (id))
create table acs_user_addresses (user_id bigint not null, addresses_id bigint not null, primary key (user_id, addresses_id))
create table address (id bigint not null, city varchar(255), pin_code varchar(255), state varchar(255), street varchar(255), primary key (id))
create table product (id bigint not null, active boolean not null, description varchar(255), name varchar(255), product_sub_type_id bigint, product_type_id bigint, primary key (id))
create table product_detail (id bigint not null, price float not null, weight float not null, product_id bigint, primary key (id))
create table product_offer (id bigint not null, active boolean not null, description varchar(255), offer_price float not null, supplier_product_id bigint, primary key (id))
create table product_sub_type (id bigint not null, active boolean not null, name varchar(255), product_type_id bigint, primary key (id))
create table product_type (id bigint not null, active boolean not null, name varchar(255), primary key (id))
create table product_type_product_sub_types (product_type_id bigint not null, product_sub_types_id bigint not null)
create table supplier (id bigint not null, active boolean not null, created_date timestamp, name varchar(255), supplier_address_id bigint, primary key (id))
create table supplier_product (id bigint not null, active boolean not null, price float not null, product_detail_id bigint, product_offer_id bigint, suppler_id bigint, primary key (id))


alter table acs_user_addresses add constraint UK_lpkfnxod933fiye5m4iymugm3 unique (addresses_id)
alter table product add constraint UKjmivyxk9rmgysrmsqw15lqr5b unique (name)
alter table product_detail add constraint UK4p3n9j219np130hpjyack64rb unique (product_id, weight)
alter table product_sub_type add constraint UKlp86mncwv6ebu9r5c6v7ckp3y unique (name)
alter table product_type add constraint UKbnu2aqss00w6he2vs4bmmy609 unique (name)
alter table product_type_product_sub_types add constraint UK_7cvlkajrc2o6tws6dkcnn6a4b unique (product_sub_types_id)
alter table supplier_product add constraint UKh9mtm3cokuu2ojgyk00t8g073 unique (suppler_id, product_detail_id)
alter table acs_user_addresses add constraint FKie6m4k7954ekecaysxurpjoko foreign key (addresses_id) references address
alter table acs_user_addresses add constraint FK464r022vd032ih2i2mx7r21b8 foreign key (user_id) references acs_user
alter table product add constraint FK9oghtp1w9io10hl7of8grfxwp foreign key (product_sub_type_id) references product_sub_type
alter table product add constraint FKlabq3c2e90ybbxk58rc48byqo foreign key (product_type_id) references product_type
alter table product_detail add constraint FKilxoi77ctyin6jn9robktb16c foreign key (product_id) references product
alter table product_offer add constraint FKj95g67i5kmp0q0jg7td0p60ek foreign key (supplier_product_id) references supplier_product
alter table product_sub_type add constraint FKlco5e6jt0h42psr59na8rw18e foreign key (product_type_id) references product_type
alter table product_type_product_sub_types add constraint FKnqtylf45q071hk2qdfmx33kjk foreign key (product_sub_types_id) references product_sub_type
alter table product_type_product_sub_types add constraint FKr3mth3ctlvrbey0xxl0pq70sh foreign key (product_type_id) references product_type
alter table supplier add constraint FK2ttf6hwlocq00vlmsmaxrdvv0 foreign key (supplier_address_id) references address
alter table supplier_product add constraint FKecf1me1gxug8tdnw9t3wgr31r foreign key (product_detail_id) references product_detail
alter table supplier_product add constraint FKom5k3w5hdagti5qrwtd2b9v13 foreign key (product_offer_id) references product_offer
alter table supplier_product add constraint FK34w0w9ts457k2279d6rcyvw1f foreign key (suppler_id) references supplier
