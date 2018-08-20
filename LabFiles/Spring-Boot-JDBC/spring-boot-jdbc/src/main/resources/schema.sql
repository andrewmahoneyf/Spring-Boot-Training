

-- ----------------------------------------------
-- DDL Statements for tables
-- ----------------------------------------------

CREATE TABLE "PURCHASE" ("ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "CUSTOMERNAME" VARCHAR(255), "PRODUCT" VARCHAR(255), "PURCHASEDATE" TIMESTAMP);

-- ----------------------------------------------
-- DDL Statements for keys
-- ----------------------------------------------

-- primary/unique
ALTER TABLE "PURCHASE" ADD CONSTRAINT "SQL120325130144010" PRIMARY KEY ("ID");

