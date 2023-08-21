ALTER TABLE "batch_base"
    ADD "quantity" double precision NULL,
ADD "description" character varying(255)  NULL,
ADD "created_at" timestamp  NULL;
ADD "corp_id" bigint NULL;
COMMENT ON TABLE "batch_base" IS '';

ALTER TABLE "batch_product"
ALTER "production_estimated" TYPE double precision,
ALTER "production_estimated" DROP DEFAULT,
ALTER "production_estimated" DROP NOT NULL,
ALTER "production_real" TYPE double precision,
ALTER "production_real" DROP DEFAULT,
ALTER "production_real" DROP NOT NULL,
DROP "invest_estimated",
DROP "invest_real",
ALTER "capacity" TYPE double precision,
ALTER "capacity" DROP DEFAULT,
ALTER "capacity" DROP NOT NULL;
ALTER TABLE "batch_product" RENAME "production_estimated" TO "price_estimated";
COMMENT ON COLUMN "batch_product"."price_estimated" IS '';
ALTER TABLE "batch_product" RENAME "production_real" TO "area";
COMMENT ON COLUMN "batch_product"."area" IS '';
ALTER TABLE "batch_product" RENAME "capacity" TO "quantity";
COMMENT ON COLUMN "batch_product"."quantity" IS '';
COMMENT ON TABLE "batch_product" IS '';

ALTER TABLE "batch_product"
ALTER "price_estimated" TYPE numeric(12,2),
ALTER "price_estimated" DROP DEFAULT,
ALTER "price_estimated" DROP NOT NULL;
COMMENT ON COLUMN "batch_product"."price_estimated" IS '';
COMMENT ON TABLE "batch_product" IS '';

ALTER TABLE "batch_product"
ALTER "price_estimated" TYPE numeric(12,2),
ALTER "price_estimated" DROP DEFAULT,
ALTER "price_estimated" DROP NOT NULL;
ALTER TABLE "batch_product" RENAME "price_estimated" TO "estimated_price";
COMMENT ON COLUMN "batch_product"."estimated_price" IS '';
COMMENT ON TABLE "batch_product" IS '';