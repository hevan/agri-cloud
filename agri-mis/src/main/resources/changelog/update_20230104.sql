ALTER TABLE "batch_cycle"
ALTER "created_at" TYPE timestamp,
ALTER "created_at" DROP DEFAULT,
ALTER "created_at" DROP NOT NULL;
COMMENT ON COLUMN "batch_cycle"."created_at" IS '';
COMMENT ON TABLE "batch_cycle" IS '';