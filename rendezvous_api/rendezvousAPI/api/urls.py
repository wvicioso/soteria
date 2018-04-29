# api/urls.py

from django.conf.urls import url, include
from rest_framework.urlpatterns import format_suffix_patterns
from .views import ProfileCreateView
from .views import ProfileDetailsView
from .views import TripCreateView
from .views import TripDetailsView
from .views import SchoolCreateView
from .views import SchoolDetailsView
from .views import MeetupCreateView
from .views import MeetupDetailsView
from .views import DestinationCreateView
from .views import DestinationDetailsView

urlpatterns = {
    url(r'^auth/', include('rest_framework.urls', # ADD THIS URL
                               namespace='rest_framework')),
    url(r'^profiles/$', ProfileCreateView.as_view(), name="create"),
    url(r'^profiles/(?P<pk>[0-9]+)/$',
    ProfileDetailsView.as_view(), name="details"),
    url(r'^trips/$', TripCreateView.as_view(), name="create"),
    url(r'^trips/(?P<pk>[0-9]+)/$',
        TripDetailsView.as_view(), name="details"),
    url(r'^schools/$', SchoolCreateView.as_view(), name="create"),
    url(r'^schools/(?P<pk>[0-9]+)/$',
        SchoolDetailsView.as_view(), name="details"),
    url(r'^meetups/$', MeetupCreateView.as_view(), name="create"),
    url(r'^meetups/(?P<pk>[0-9]+)/$',
        MeetupDetailsView.as_view(), name="details"),
    url(r'^destinations/$', DestinationCreateView.as_view(), name="create"),
    url(r'^destinations/(?P<pk>[0-9]+)/$',
        DestinationDetailsView.as_view(), name="details"),
}

urlpatterns = format_suffix_patterns(urlpatterns)
