# api/views.py

from rest_framework import generics
from .serializers import TripSerializer
from .models import Trip
from .serializers import SchoolSerializer
from .models import School
from .serializers import MeetupSerializer
from .models import Meetup
from .serializers import DestinationSerializer
from .models import Destination

class TripCreateView(generics.ListCreateAPIView):
    """This class defines the create behavior of our rest api."""
    queryset = Trip.objects.all()
    serializer_class = TripSerializer

    def perform_create(self, serializer):
        """Save the post data when creating a new Trip."""
        serializer.save()

class TripDetailsView(generics.RetrieveUpdateDestroyAPIView):
    """This class handles the http GET, PUT and DELETE requests."""

    queryset = Trip.objects.all()
    serializer_class = TripSerializer

class SchoolCreateView(generics.ListCreateAPIView):
    """This class defines the create behavior of our rest api."""
    queryset = School.objects.all()
    serializer_class = SchoolSerializer

    def perform_create(self, serializer):
        """Save the post data when creating a new Trip."""
        serializer.save()

class SchoolDetailsView(generics.RetrieveUpdateDestroyAPIView):
    """This class handles the http GET, PUT and DELETE requests."""

    queryset = School.objects.all()
    serializer_class = SchoolSerializer

class MeetupCreateView(generics.ListCreateAPIView):
    """This class defines the create behavior of our rest api."""
    queryset = Meetup.objects.all()
    serializer_class = MeetupSerializer

    def perform_create(self, serializer):
        """Save the post data when creating a new Trip."""
        serializer.save()

class MeetupDetailsView(generics.RetrieveUpdateDestroyAPIView):
    """This class handles the http GET, PUT and DELETE requests."""

    queryset = Meetup.objects.all()
    serializer_class = MeetupSerializer

class DestinationCreateView(generics.ListCreateAPIView):
    """This class defines the create behavior of our rest api."""
    queryset = Destination.objects.all()
    serializer_class = DestinationSerializer

    def perform_create(self, serializer):
        """Save the post data when creating a new Trip."""
        serializer.save()

class DestinationDetailsView(generics.RetrieveUpdateDestroyAPIView):
    """This class handles the http GET, PUT and DELETE requests."""

    queryset = Destination.objects.all()
    serializer_class = DestinationSerializer
