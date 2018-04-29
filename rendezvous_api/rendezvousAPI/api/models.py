# api/models.py

from django.db import models

class Profile(models.Model):
    """This class represents the Profile model."""
    user = models.ForeignKey('auth.User', on_delete=models.CASCADE, default=1)
    url = models.CharField(max_length=255, blank=True, unique=True)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

class Trip(models.Model):
    """This class represents the trip model."""
    meetup = models.CharField(max_length=255, blank=False)
    destination = models.CharField(max_length=255, blank=False)
    users = models.ManyToManyField(Profile)
    time = models.DateTimeField(default=None)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

    def __str__(self):
        """Return a human readable representation of the model instance."""
        return "{}".format(self.name)

class School(models.Model):
    """This class represents the trip model."""
    name = models.CharField(max_length=255, blank=False, unique=True)
    domain = models.CharField(max_length=255, blank=False)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

    def __str__(self):
        """Return a human readable representation of the model instance."""
        return "{}".format(self.name)

class Destination(models.Model):
    """This class represents the trip model."""
    train_stop = models.CharField(max_length=255, blank=False)
    school = models.ForeignKey(School, db_column='name', on_delete=models.CASCADE)
    lat = models.CharField(max_length=255, blank=False)
    long = models.CharField(max_length=255, blank=False)
    trains = models.CharField(max_length=255, blank=False)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

class Meetup(models.Model):
    """This class represents the trip model."""
    address = models.CharField(max_length=255, blank=False)
    school = models.ForeignKey(School, db_column='name', on_delete=models.CASCADE)
    lat = models.CharField(max_length=255, blank=False)
    long = models.CharField(max_length=255, blank=False)
    date_created = models.DateTimeField(auto_now_add=True)
    date_modified = models.DateTimeField(auto_now=True)

    def __str__(self):
        """Return a human readable representation of the model instance."""
        return "{}".format(self.name)
