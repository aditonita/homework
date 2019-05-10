-- SELECT p.plan_id, p.NAME, p.max_rentals, p.monthly_fee FROM plan p;

-- SELECT c.login, c.cid,c.PASSWORD,c.first_name,c.last_name,c.rental_plan FROM customer c

-- SELECT r.`status` FROM rental r WHERE r.movie_id = 'M_100';

-- SELECT r.cid, r.movie_id, r.`status`, r.rented_times FROM rental r WHERE r.movie_id = '';

-- INSERT INTO rental (cid, movie_id, `status`, rented_times) VALUES (1, 'M_101', 'open', 2);

-- acountsUPDATE rental SET cid=3, `status`='open', rented_times=1 WHERE movie_id='M_1060';


SELECT r.cid, r.movie_id, r.`status`, r.rented_times FROM rental r;