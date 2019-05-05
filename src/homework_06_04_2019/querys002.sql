-- INSERT INTO cards_info (acount_id, card_number, card_pin, active) VALUES  (5, '1001100210021003', '1111', TRUE)

-- UPDATE acounts a SET a.client_id=a.client_id, a.account_number=a.account_number, a.amount = 100.5, a.active = FALSE WHERE a.account_id=5

UPDATE cards_info c 
  SET c.acount_id=c.acount_id, 
    c.card_number=c.card_number,
    c.card_pin='9999',
    c.active=false
      WHERE c.card_id=10
