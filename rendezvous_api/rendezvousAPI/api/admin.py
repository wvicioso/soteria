from django.contrib import admin
from .models import Profile
from .models import Trip
from .models import School
from .models import Meetup
from .models import Destination

admin.site.register(Profile)
admin.site.register(Trip)
admin.site.register(School)
admin.site.register(Destination)
admin.site.register(Meetup)
