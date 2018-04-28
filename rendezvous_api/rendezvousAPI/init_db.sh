#!/bin/sh
echo "------ Create database tables ------"
python manage.py makemigrations
python manage.py migrate --noinput
 
echo "------ create default admin user ------"
echo "------ User Name = harry	       ------"
echo "------ Password  = IRIS dataset  ------"
echo "from django.contrib.auth.models import User; User.objects.create_superuser('harry', 'super_user@myapp.local', 'googoodolls')" | python manage.py shell
 
echo "------ starting gunicorn &nbsp;------"
gunicorn rendezvousAPI.wsgi --workers 2

python manage.py runserver
