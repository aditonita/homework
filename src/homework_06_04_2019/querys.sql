-- get cardsByClientAccount
-- SELECT * FROM cards_info ci WHERE ci.acount_id IN (
--	SELECT a.account_id FROM acounts a WHERE a.client_id IN (
--		SELECT c.client_id FROM clients c WHERE c.client_name = 'Adi,Tonita'
--		) and a.acount_number = 'RO32BTRL00U78456TAA0000'
--	);
	
-- SELECT * FROM clients c WHERE c.client_name = 'Adi,Tonita';
-- SELECT c.client_id, c.client_name, c.client_address FROM clients c WHERE c.client_id = '1720807001003';
-- SELECT a.account_id, a.client_id, a.acount_number, a.amount, a.active FROM acounts a WHERE a.client_id = '1720807001003';
-- SELECT ci.card_id, ci.acount_id, ci.card_number, ci.card_pin, ci.active FROM cards_info ci WHERE ci.acount_id = 2;

-- SELECT c.client_id, c.client_name, c.client_address FROM clients c WHERE c.client_id IN (
--  SELECT a.client_id FROM acounts a WHERE a.account_id IN (
--    SELECT ci.acount_id FROM cards_info ci WHERE ci.card_number = '1001100110011001'
--    )
--  )

-- SELECT a.account_id, a.client_id, a.acount_number, a.amount, a.active FROM acounts a WHERE a.account_id IN (
--  SELECT ci.acount_id FROM cards_info ci WHERE ci.card_number = '1001100110011001'
--  )
 
INSERT INTO clients (client_id, client_name, client_address) VALUES ('2980930123456','Ely,Toma','str. Primaverii 23, Iasi')
INSERT INTO acounts (client_id, acount_number, amount, active) SELECT c.client_id, 'RO57INGB00896002xx' AS acount_number, 1050.34 AS amount, TRUE AS active  FROM clients c WHERE c.client_id = '2980930123456'

INSERT INTO cards_info (acount_id, card_number, card_pin, active) 
SELECT a.account_id AS acount_id, '1002100210021002' AS card_number, '1234' AS card_pin, TRUE AS active FROM acounts a WHERE a.client_id IN (
SELECT c.client_id FROM clients c WHERE c.client_id='2980930123456'
) AND a.account_id = 7

-- INSERT INTO clients (client_id, client_name, clien_address) VALUES ('2980930123456','Ely,Toma','str. Primaverii 23, Iasi')
DELETE FROM clients WHERE client_id = '2980930123456'

DELETE FROM acounts WHERE acount_id = ?


UPDATE clients c SET c.client_address = 'str. Bucuresti 102, Cluj' WHERE c.client_id = '2980930123456';

SELECT MAX(a.account_id) FROM acounts a
