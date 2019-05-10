SELECT m.movie_id, m.movie_name, m.YEAR, m.rating 
	FROM movie_info m 
		WHERE m.movie_name LIKE '%all in%';

SELECT DISTINCT p.producer_id, p.producer_name, m.movie_id 
	FROM producer_ids p, producer_movies pm,  movie_info m 
		WHERE p.producer_id = pm.producer_id 
		AND pm.movie_id = m.movie_id 
		AND m.movie_name LIKE '%all in%';

SELECT DISTINCT  a.actor_id, a.actor_name, a.gender, m.movie_id 
	FROM  actor_ids a, actor_movies am, movie_info m 
		WHERE a.actor_id = am.actor_id 
		AND am.movie_id = m.movie_id 
		AND m.movie_name LIKE '%all in%';


SELECT DISTINCT p.producer_id, p.producer_name  
	FROM producer_ids p, producer_movies pm  
		WHERE p.producer_id = pm.producer_id 
		AND pm.movie_id = 'M_3669'; 

SELECT DISTINCT  a.actor_id, a.actor_name, a.gender 
	FROM  actor_ids a, actor_movies am 
		WHERE a.actor_id = am.actor_id 
		AND am.movie_id = 'M_3669' 

-- SELECT DISTINCT m.movie_name, a.actor_name, p.producer_name  
--	FROM  actor_ids a, actor_movies am, producer_ids p, producer_movies pm, movie_info m 
--		WHERE a.actor_id = am.actor_id 
--		AND am.movie_id = m.movie_id 
--		AND p.producer_id = pm.producer_id
--		AND pm.movie_id = m.movie_id
--		AND m.movie_name LIKE '%all in%'  
