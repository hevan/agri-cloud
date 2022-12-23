ALTER TABLE "cms_blog"
ALTER "created_by" TYPE character varying(50),
ALTER "created_by" DROP DEFAULT,
ALTER "created_by" DROP NOT NULL;
COMMENT ON COLUMN "cms_blog"."created_by" IS '';

DROP TABLE "cms_video";

ALTER TABLE "cms_blog"
ADD "video_url" character varying(255) NULL;
COMMENT ON COLUMN "cms_blog"."video_url" IS '';
COMMENT ON TABLE "cms_blog" IS '';

ALTER TABLE "cms_resource"
ALTER "entity_id" TYPE bigint,
ALTER "entity_id" DROP DEFAULT,
ALTER "entity_id" DROP NOT NULL,
DROP "entity_name";
ALTER TABLE "cms_resource" RENAME "entity_id" TO "blog_id";
COMMENT ON COLUMN "cms_resource"."blog_id" IS '';
COMMENT ON TABLE "cms_resource" IS '';

DROP TABLE IF EXISTS "cms_tag";
DROP SEQUENCE IF EXISTS cms_tag_id_seq;
CREATE SEQUENCE cms_tag_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."cms_tag" (
    "id" bigint DEFAULT nextval('cms_tag_id_seq') NOT NULL,
    "name" character varying(50) NOT NULL,
    CONSTRAINT "cms_tag_pkey" PRIMARY KEY ("id")
) WITH (oids = false);
