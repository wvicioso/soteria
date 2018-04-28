# api/models.py

from django.db import models

class User(models.Model):
    """This class represents the User model."""
    name = models.CharField(max_length=255, blank=False, unique=True)
    phone = models.IntegerField(blank=False, unique=True)
    email = models.EmailField(max_length=254, blank=False, unique=True)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

class Trip(models.Model):
    """This class represents the trip model."""
    meetup = models.CharField(max_length=255, blank=False)
    destination = models.CharField(max_length=255, blank=False)
    users = models.ManyToManyField(User)
    time = models.DateTimeField(default=None)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

    def __str__(self):
        """Return a human readable representation of the model instance."""
        return "{}".format(self.name)
