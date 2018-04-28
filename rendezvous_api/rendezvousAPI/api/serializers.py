# api/serializers.py

from rest_framework import serializers
from .models import Trip

class TripSerializer(serializers.ModelSerializer):
    """Serializer to map the Model instance into JSON format."""

    class Meta:
        """Meta class to map serializer's fields with the model fields."""
        model = Trip
        fields = ('id', 'meetup', 'destination', 'users', 'time', 'date_created', 'date_modified')
        read_only_fields = ('date_created', 'date_modified')
