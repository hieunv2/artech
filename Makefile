build:
	docker-compose build
dev:
	docker-compose run --rm app

up:
	docker-compose up -d mysql-db

down:
	docker-compose down