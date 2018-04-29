"""
IMPORTANT!
THIS IS WHERE WE POPULATE OUR DATABASE

"""

from django.core.management.base import BaseCommand
from django.contrib.auth.models import User
from api.models import *
# from datetime import date, datetime, time, timedelta
# from dateutil.relativedelta import relativedelta
# import calendar
import csv

class Command(BaseCommand):
    args = '<foo bar ...>'
    help = 'our help string comes here'

    def _populate_schools(self):
        school_names = ["Baruch", "City College of New York", "Lehman"]
        domain_names = ["baruchmail.cuny.edu", "citymail.cuny.edu", "lc.cuny.edu"]

        for i in range(len(school_names)):
        	instance = School(name=school_names[i], domain=domain_names[i])
        	instance.save()

        print ("\n SCHOOLS TABLE POPULATED SUCCESSFULLY\n")

    def _populate_destination(self):

    	for i in ["Baruch", "City College of New York", "Lehman"]: 
    		school = School.objects.get(name=i)

    		with open("./api/management/commands/stations.csv", 'r') as file:
    			dest = csv.reader(file, delimiter=',')
    			count = 0
    			for row in dest:
    				if count == 0:
    					pass
    				else:
    					if(row[6].lower() == school.__str__().lower()):
    						instance = Destination(train_stop=row[1], school=school, lat=row[4], long=row[5], trains=row[3])
    						instance.save()
    				count+=1

    	print ("\n DESTINATION TABLE POPULATED SUCCESSFULLY\n")


    def _populate_meetup(self): 

    	coords = [(40.740638,-73.9851237), (40.8196311,-73.9505155), (40.8732913,-73.8937941)]
    	addresses = ["William and Anita Newman Library", "North Academic Center" , "Harmony Cafe"]
    	colleges = ["Baruch", "City College of New York", "Lehman"]

    	for i in range(3): 
    		school = School.objects.get(name=colleges[i])
    		instance = Meetup(address=addresses[i], school=school, lat=coords[i][0], long=coords[i][1])
    		instance.save()
    	print ("\n MEETUP TABLE POPULATED SUCCESSFULLY\n")

    def _populate_users(self):
    	
    	users = ["mofizur_rahman","Beth_Morrow", "Faith_Fraser", "Philip_Delvecchio", "Raymond_Blum", "Peter_Harrison",  "Iynna_Hililou"]
    	count = 0
    	for i in users:
    		random = User.objects.create_user(i.lower(), password='hackathon')
    		instance = Profile(user=random, url=count)
    		instance.save()
    		count+=1
    	print ("\n Users TABLE POPULATED SUCCESSFULLY\n")

    def handle(self, *args, **options):
        # self._populate_schools()
        # self._populate_destination()
        # self._populate_meetup()
        self._populate_users()