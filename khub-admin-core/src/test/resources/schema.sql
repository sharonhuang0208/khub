create table activity (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, type varchar(50), primary key (uuid))
create table activity_attachment (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, activity_type varchar(20), created_by varchar(200), extent bigint, filename varchar(255), has_full_text bit, last_modified_by varchar(200), path varchar(50), record_status integer, activity_uuid varchar(255), primary key (uuid))
create table activity_link (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, activity_type varchar(20), created_by varchar(200), last_modified_by varchar(200), name varchar(255), url varchar(255), activity_uuid varchar(255), primary key (uuid))
create table application (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), description varchar(200), last_modified_by varchar(200), name varchar(100), primary key (uuid))
create table attending_organization (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, activity_type varchar(20), created_by varchar(200), language varchar(5), last_modified_by varchar(200), org_country varchar(50), org_country_code varchar(5), org_name varchar(255), org_name_en varchar(255), role_code varchar(50), activity_uuid varchar(255), org_uuid varchar(255), primary key (uuid))
create table attending_people (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, activity_type varchar(20), created_by varchar(200), department_addr varchar(50), email varchar(200), first_name varchar(50), first_name_en varchar(50), full_name varchar(100), full_name_en varchar(100), is_corresponding_author bit, language varchar(5), last_modified_by varchar(200), last_name varchar(50), last_name_en varchar(50), role_code varchar(50), seq integer, activity_uuid varchar(255), people_uuid varchar(255), primary key (uuid))
create table backend_user (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, account_id varchar(200), contact_tel varchar(50), created_by varchar(200), data_permission_level integer not null, email varchar(200), last_modified_by varchar(200), name varchar(50), password varchar(50), status integer not null, primary key (uuid))
create table code (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, code varchar(5) not null, description varchar(255), language varchar(5) not null, seq integer, status integer not null, type integer not null, type_desc varchar(255), primary key (uuid))
create table conference_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, authority bit, city varchar(50), city_code varchar(5), conference_id varchar(50), country varchar(50), country_code varchar(5), created_by varchar(200), end_date date, founding_source varchar(30), language varchar(5), last_modified_by varchar(200), meeting_abstract longtext, name varchar(255), name_en varchar(255), postcode varchar(10), remark longtext, school_year varchar(5), start_date date, state varchar(50), state_code varchar(5), type_code varchar(5), wos_abstract_number varchar(50), wos_conference_id varchar(50), wos_full_info varchar(255), activity_uuid varchar(255), primary key (uuid))
create table contact (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), last_modified_by varchar(200), type varchar(50), org_uuid varchar(255), primary key (uuid))
create table contact_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), email varchar(200), fax_number varchar(20), job_title varchar(100), language varchar(5), last_modified_by varchar(200), name varchar(100), phone_number varchar(20), contact_uuid varchar(255), primary key (uuid))
create table current_post (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), last_modified_by varchar(200), people_uuid varchar(255), primary key (uuid))
create table current_post_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, admin_job_title varchar(100), administration varchar(5), created_by varchar(200), engagement varchar(5), honorary_title varchar(50), job_title varchar(5), last_modified_by varchar(200), current_post_uuid varchar(255), org_uuid varchar(255), primary key (uuid))
create table education (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), last_modified_by varchar(200), people_uuid varchar(255), primary key (uuid))
create table education_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), duration_begin_y varchar(4), duration_end_y varchar(4), edu varchar(50), last_modified_by varchar(200), org_name varchar(255), education_uuid varchar(255), org_uuid varchar(255), primary key (uuid))
create table experience (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), last_modified_by varchar(200), people_uuid varchar(255), primary key (uuid))
create table experience_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), duration_begin_y varchar(4), duration_end_y varchar(4), last_modified_by varchar(200), org_name varchar(255), position varchar(50), experience_uuid varchar(255), organization_uuid varchar(255), people_uuid varchar(255), primary key (uuid))
create table language (id varchar(255) not null, created_time datetime, last_modified_time datetime, description varchar(100), display_name varchar(50), nationality varchar(5), type varchar(50), primary key (id))
create table member (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, account_id varchar(200), city varchar(100), college varchar(100), country varchar(100), country_code varchar(10), created_by varchar(200), department varchar(100), full_name varchar(100), full_name_en varchar(100), id_no varchar(50), job_title varchar(50), lang varchar(50), last_modified_by varchar(200), organization_id varchar(50), organization_name varchar(200), organization_type integer, state varchar(100), status integer not null, university varchar(100), people_uuid varchar(255), primary key (uuid))
create table nationality (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, ch varchar(100), code varchar(2) not null, en varchar(100), primary key (uuid))
create table org_data_permission (user_uuid varchar(255) not null, org_uuid varchar(255) not null, primary key (user_uuid, org_uuid))
create table organization (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, college_id varchar(50), created_by varchar(200), last_modified_by varchar(200), org_id varchar(50), project_sys_id varchar(50), scopus_org_id varchar(50), tax_id varchar(50), type varchar(5), wos_org_id varchar(50), parent_uuid varchar(255), primary key (uuid))
create table organization_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, addr varchar(255), area_knowledge longtext, authority bit, brief longtext, city varchar(50), city_code varchar(5), college varchar(100), country varchar(50), country_code varchar(5), created_by varchar(200), department varchar(100), founding_year varchar(4), group_type varchar(100), last_modified_by varchar(200), news_url longtext, notes longtext, org_name varchar(255), org_name_en varchar(255), other_name varchar(255), postcode varchar(10), scopus_url varchar(255), website varchar(255), language_id varchar(255), org_uuid varchar(255), primary key (uuid))
create table people (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), id_no varchar(50), last_modified_by varchar(200), library_sys_id varchar(50), orcid varchar(50), person_id varchar(50), researcher_id varchar(50), scopus_author_id varchar(50), scopus_exp_id varchar(50), teacher_id varchar(50), primary key (uuid))
create table people_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, authority bit, created_by varchar(200), email longtext, first_name varchar(50), first_name_en varchar(50), full_name varchar(100), full_name_en varchar(100), lab longtext, language varchar(5), last_modified_by varchar(200), last_name varchar(50), last_name_en varchar(50), name_variant varchar(255), nationality_code varchar(2), notes longtext, nthur_link varchar(255), other_name varchar(255), other_name_en varchar(255), research_area longtext, scopus_author_link varchar(100), website longtext, people_uuid varchar(255), primary key (uuid))
create table photo (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), file_name varchar(50), file_path varchar(50), last_modified_by varchar(200), seq integer, url varchar(50), people_uuid varchar(255), primary key (uuid))
create table publication_info (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, abbreviated_source_title varchar(255), abstract longtext, abstract_en longtext, access_right integer, access_right_date datetime, article_number varchar(50), author_amt integer, author_keywords varchar(255), authority bit, cc varchar(50), chemicals_cas varchar(255), citation varchar(255), coden varchar(50), collection varchar(50), collection_id varchar(50), copyright longtext, created_by varchar(200), db_source_auto_code varchar(5), doi varchar(255), edition varchar(50), eid varchar(50), electronic_id varchar(50), firstpage integer, founding_source varchar(50), funcing_purposes varchar(50), google_scholar_url varchar(255), has_translated bit, index_keywords varchar(255), isbn varchar(20), issn varchar(50), issue varchar(50), keyword_plus varchar(255), khub_publication_type_code varchar(5), language varchar(5), language_org varchar(5), last_modified_by varchar(200), lastpage integer, manufacturers varchar(50), media varchar(50), notes longtext, nthur_url longtext, other_title varchar(255), other_title_en varchar(255), page_count integer, pdf_security bit, peer_review bit, pub_med_id varchar(50), publication_day varchar(2), publication_month varchar(2), publication_place varchar(50), publication_type_code varchar(5), publication_year varchar(4), publisher varchar(50), record_status integer, refs longtext, related_link longtext, remark longtext, reservation_keywords varchar(255), reservation_keywords_en varchar(255), scopus_abstract_url varchar(255), scopus_cited_by_url varchar(255), scopus_cited_times integer, scopus_is_high_cited bit, scopus_publication_id varchar(50), scopus_references_cnt integer, source_link varchar(200), source_title varchar(255), special_issue varchar(50), subject_scopus longtext, subject_wos longtext, sysid varchar(50), title varchar(255), title_en varchar(255), tradenames varchar(50), type varchar(50), volume varchar(50), wos_article_number varchar(50), wos_book_chapter_count integer, wos_cited_times integer, wos_is_high_cited bit, wos_references_cnt integer, wos_related_records longtext, activity_uuid varchar(255), primary key (uuid))
create table related_activity_map (activity_uuid varchar(255) not null, related_activity_uuid varchar(255) not null, primary key (activity_uuid, related_activity_uuid))
create table resource (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), description varchar(200), last_modified_by varchar(200), name varchar(100), restriction varchar(100), status integer not null, url varchar(100), applicatio_uuid varchar(255) not null, parent_uuid varchar(255), primary key (uuid))
create table resource_role_map (role_uuid varchar(255) not null, resource_uuid varchar(255) not null, primary key (role_uuid, resource_uuid))
create table role (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, created_by varchar(200), description varchar(200), last_modified_by varchar(200), name varchar(100), seq integer, status integer not null, primary key (uuid))
create table scopus_statistics (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, avg_citations_per_article integer, coauthors_num integer, created_by varchar(200), h_index integer, h_sum_times_cited integer, last_modified_by varchar(200), sum_times_cited integer, ublications_num integer, people_uuid varchar(255), primary key (uuid))
create table user_data_permission (user_uuid varchar(255) not null, member_uuid varchar(255) not null, primary key (user_uuid, member_uuid))
create table user_role_map (user_uuid varchar(255) not null, role_uuid varchar(255) not null, primary key (user_uuid, role_uuid))
create table wos_statistics (uuid varchar(255) not null, created_time datetime, last_modified_time datetime, avg_citations_per_article integer, coauthors_num integer, created_by varchar(200), h_index integer, h_sum_times_cited integer, last_modified_by varchar(200), publications_num integer, sum_times_cited integer, people_uuid varchar(255), primary key (uuid))
alter table activity_attachment add constraint FKbbpemhaod9p17jc9uystsqrlj foreign key (activity_uuid) references activity (uuid)
alter table activity_link add constraint FKgg6550nufxq6o2nc7hcar1dk6 foreign key (activity_uuid) references activity (uuid)
alter table attending_organization add constraint FKa3hlmj835lyyetdj2p7o9r4yf foreign key (activity_uuid) references activity (uuid)
alter table attending_organization add constraint FK3danypfcaov2828rw2nqh8ugu foreign key (org_uuid) references organization (uuid)
alter table attending_people add constraint FKrli4h9yudmut42pkniqd6is2r foreign key (activity_uuid) references activity (uuid)
alter table attending_people add constraint FKkd2kdj75tvf4hh154edaw649h foreign key (people_uuid) references people (uuid)
alter table code add constraint UKfxn0ki06edqh733mkigbl9fpq unique (type, code, language)
alter table conference_info add constraint FKc3xb2indqhyrrobirqfodgd34 foreign key (activity_uuid) references activity (uuid)
alter table contact add constraint FK1hi3f08s13bkb8e8fgmx2c2pg foreign key (org_uuid) references organization (uuid)
alter table contact_info add constraint FK65wd56fqnciu0p97ugxw6gkoh foreign key (contact_uuid) references contact (uuid)
alter table current_post add constraint FKfto93q222enhoau03k6jvfg1s foreign key (people_uuid) references people (uuid)
alter table current_post_info add constraint FKdems4xxyw8msamm34ntq8l3xn foreign key (current_post_uuid) references current_post (uuid)
alter table current_post_info add constraint FK3i6dgkrobk54h5xcxad9nsx7t foreign key (org_uuid) references organization (uuid)
alter table education add constraint FKd9gnvvtthhrxq1451501k75ye foreign key (people_uuid) references people (uuid)
alter table education_info add constraint FK2xikkwg6n2o8v9hm758tg2n3p foreign key (education_uuid) references education (uuid)
alter table education_info add constraint FK2gpk89n0l3fv5j8xq298f6ta2 foreign key (org_uuid) references organization (uuid)
alter table experience add constraint FK7fbd88cdaouojeccg1hk00gox foreign key (people_uuid) references people (uuid)
alter table experience_info add constraint FKsffa3o3sris618drq3bmn0vyx foreign key (experience_uuid) references experience (uuid)
alter table experience_info add constraint FKgnaf40fss23wp67kptg2i6ypo foreign key (organization_uuid) references organization (uuid)
alter table experience_info add constraint FKrk8lrj248h3t1cg4j8qqk0utf foreign key (people_uuid) references people (uuid)
alter table member add constraint FKlmi6y4ts4dvua0qe101q4uun6 foreign key (people_uuid) references people (uuid)
alter table org_data_permission add constraint FKsi7iahr2dc2viybtawn74q0n9 foreign key (org_uuid) references organization (uuid)
alter table org_data_permission add constraint FK7hmlgcnhos69uo32l17spnfhx foreign key (user_uuid) references backend_user (uuid)
alter table organization add constraint FK1n1i44r7mmvm10mps55xwr45j foreign key (parent_uuid) references organization (uuid)
alter table organization_info add constraint FK4w0nvqub2nr1mn6sgtuscmuv6 foreign key (language_id) references language (id)
alter table organization_info add constraint FKer9ud4mpb41x013d9ephc91j9 foreign key (org_uuid) references organization (uuid)
alter table people_info add constraint FKt2s9bdmu2qie0tf46solq7a8o foreign key (people_uuid) references people (uuid)
alter table photo add constraint FKnbxxnutfvin5jicpcc8hg30iq foreign key (people_uuid) references people (uuid)
alter table publication_info add constraint FKr1onjjljbxbcjdowew0qpdku1 foreign key (activity_uuid) references activity (uuid)
alter table related_activity_map add constraint FK1lpv5vcbpm4u81d9jhw4adl5b foreign key (related_activity_uuid) references activity (uuid)
alter table related_activity_map add constraint FK46j80y1g6vu4ouko0j2s3wgmt foreign key (activity_uuid) references activity (uuid)
alter table resource add constraint FK8iie2h48f8xau4e4nxy7pgpim foreign key (applicatio_uuid) references application (uuid)
alter table resource add constraint FKg8tieofrfjbwuss3w51ctrqmq foreign key (parent_uuid) references resource (uuid)
alter table resource_role_map add constraint FK6dsk9wmlo8aifnkdleod3awor foreign key (resource_uuid) references resource (uuid)
alter table resource_role_map add constraint FKmbkm84wm3og5bhwne2i9gegbe foreign key (role_uuid) references role (uuid)
alter table scopus_statistics add constraint FKa2ttqsgvc7q9c24l858h4sw9m foreign key (people_uuid) references people (uuid)
alter table user_data_permission add constraint FK2vmstumgqucqosaculp3y2gut foreign key (member_uuid) references member (uuid)
alter table user_data_permission add constraint FKnixasniaydh0u0tb8ad9yscsk foreign key (user_uuid) references backend_user (uuid)
alter table user_role_map add constraint FK4q4blkl04fxp4lhg3s48ojnyc foreign key (role_uuid) references role (uuid)
alter table user_role_map add constraint FKhxvwjrixv4beim53iw3siqtph foreign key (user_uuid) references backend_user (uuid)
alter table wos_statistics add constraint FKdhv8rh5eohod2r69np67007yh foreign key (people_uuid) references people (uuid)
