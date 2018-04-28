# api/urls.py

from django.conf.urls import url, include
from rest_framework.urlpatterns import format_suffix_patterns
from .views import TripCreateView
from .views import TripDetailsView

urlpatterns = {
    url(r'^trips/$', TripCreateView.as_view(), name="create"),
    url(r'^trips/(?P<pk>[0-9]+)/$',
        TripDetailsView.as_view(), name="details"),
}

urlpatterns = format_suffix_patterns(urlpatterns)
