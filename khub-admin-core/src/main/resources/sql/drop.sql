alter table khub.activity_attachment drop foreign key FKbbpemhaod9p17jc9uystsqrlj
alter table khub.activity_link drop foreign key FKgg6550nufxq6o2nc7hcar1dk6
alter table khub.attending_organization drop foreign key FKa3hlmj835lyyetdj2p7o9r4yf
alter table khub.attending_organization drop foreign key FKqsay2lf4pd4xlsv1shw37crqd
alter table khub.attending_organization drop foreign key FK3danypfcaov2828rw2nqh8ugu
alter table khub.attending_people drop foreign key FKrli4h9yudmut42pkniqd6is2r
alter table khub.attending_people drop foreign key FKgk85wghj65sc015i7r4cuqna9
alter table khub.attending_people drop foreign key FKkd2kdj75tvf4hh154edaw649h
alter table khub.code drop foreign key FKplye5jp86jth15uo344w0n7ri
alter table khub.conference_info drop foreign key FKc3xb2indqhyrrobirqfodgd34
alter table khub.conference_info drop foreign key FK2vc0fg495tmulwnhs9b6y5o5j
alter table khub.contact drop foreign key FK1hi3f08s13bkb8e8fgmx2c2pg
alter table khub.contact_info drop foreign key FK65wd56fqnciu0p97ugxw6gkoh
alter table khub.contact_info drop foreign key FKjvg6j3yfff7k1v6wju0jpmimo
alter table khub.current_post drop foreign key FKfto93q222enhoau03k6jvfg1s
alter table khub.current_post_info drop foreign key FKdems4xxyw8msamm34ntq8l3xn
alter table khub.current_post_info drop foreign key FK3i6dgkrobk54h5xcxad9nsx7t
alter table khub.education drop foreign key FKd9gnvvtthhrxq1451501k75ye
alter table khub.education_info drop foreign key FK2xikkwg6n2o8v9hm758tg2n3p
alter table khub.education_info drop foreign key FK2gpk89n0l3fv5j8xq298f6ta2
alter table khub.experience drop foreign key FK7fbd88cdaouojeccg1hk00gox
alter table khub.experience_info drop foreign key FKsffa3o3sris618drq3bmn0vyx
alter table khub.experience_info drop foreign key FKgnaf40fss23wp67kptg2i6ypo
alter table khub.experience_info drop foreign key FKrk8lrj248h3t1cg4j8qqk0utf
alter table khub.member drop foreign key FKlmi6y4ts4dvua0qe101q4uun6
alter table khub.org_data_permission drop foreign key FKsi7iahr2dc2viybtawn74q0n9
alter table khub.org_data_permission drop foreign key FK7hmlgcnhos69uo32l17spnfhx
alter table khub.organization drop foreign key FK1n1i44r7mmvm10mps55xwr45j
alter table khub.organization_info drop foreign key FK4w0nvqub2nr1mn6sgtuscmuv6
alter table khub.organization_info drop foreign key FKer9ud4mpb41x013d9ephc91j9
alter table khub.people_info drop foreign key FKnlcjckebrns15ucxax56hdsyf
alter table khub.people_info drop foreign key FKt2s9bdmu2qie0tf46solq7a8o
alter table khub.photo drop foreign key FKnbxxnutfvin5jicpcc8hg30iq
alter table khub.publication_info drop foreign key FKr1onjjljbxbcjdowew0qpdku1
alter table khub.publication_info drop foreign key FKbeyghdecjij3ubxi4nssw4929
alter table khub.related_activity_map drop foreign key FK1lpv5vcbpm4u81d9jhw4adl5b
alter table khub.related_activity_map drop foreign key FK46j80y1g6vu4ouko0j2s3wgmt
alter table khub.resource drop foreign key FK8iie2h48f8xau4e4nxy7pgpim
alter table khub.resource drop foreign key FKg8tieofrfjbwuss3w51ctrqmq
alter table khub.resource_role_map drop foreign key FK6dsk9wmlo8aifnkdleod3awor
alter table khub.resource_role_map drop foreign key FKmbkm84wm3og5bhwne2i9gegbe
alter table khub.scopus_statistics drop foreign key FKa2ttqsgvc7q9c24l858h4sw9m
alter table khub.user_data_permission drop foreign key FK2vmstumgqucqosaculp3y2gut
alter table khub.user_data_permission drop foreign key FKnixasniaydh0u0tb8ad9yscsk
alter table khub.user_role_map drop foreign key FK4q4blkl04fxp4lhg3s48ojnyc
alter table khub.user_role_map drop foreign key FKhxvwjrixv4beim53iw3siqtph
alter table khub.wos_statistics drop foreign key FKdhv8rh5eohod2r69np67007yh
drop table if exists khub.activity
drop table if exists khub.activity_attachment
drop table if exists khub.activity_link
drop table if exists khub.application
drop table if exists khub.attending_organization
drop table if exists khub.attending_people
drop table if exists khub.backend_user
drop table if exists khub.code
drop table if exists khub.conference_info
drop table if exists khub.contact
drop table if exists khub.contact_info
drop table if exists khub.current_post
drop table if exists khub.current_post_info
drop table if exists khub.education
drop table if exists khub.education_info
drop table if exists khub.experience
drop table if exists khub.experience_info
drop table if exists khub.language
drop table if exists khub.member
drop table if exists khub.nationality
drop table if exists khub.org_data_permission
drop table if exists khub.organization
drop table if exists khub.organization_info
drop table if exists khub.people
drop table if exists khub.people_info
drop table if exists khub.photo
drop table if exists khub.publication_info
drop table if exists khub.related_activity_map
drop table if exists khub.resource
drop table if exists khub.resource_role_map
drop table if exists khub.role
drop table if exists khub.scopus_statistics
drop table if exists khub.user_data_permission
drop table if exists khub.user_role_map
drop table if exists khub.wos_statistics
