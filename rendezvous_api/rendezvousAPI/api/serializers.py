# api/serializers.py

from rest_framework import serializers
from .models import Trip
from .models import School
from .models import Meetup
from .models import Destination

class TripSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = Trip
        fields = ('id', 'meetup', 'destination', 'users', 'time', 'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')

class SchoolSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = School
        fields = ('id', 'name', 'domain', 'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')

class MeetupSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = Meetup
        fields = ('address', 'school', 'lat', 'long', 'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')

class DestinationSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = Destination
        fields = ('train_stop', 'school', 'lat', 'long', 'trains', 'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')
