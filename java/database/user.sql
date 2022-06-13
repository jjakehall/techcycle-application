-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER climbing_app_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO climbing_app_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO climbing_app_owner;

CREATE USER climbing_app_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO climbing_app_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO climbing_app_appuser;
