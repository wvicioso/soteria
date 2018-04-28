FROM python:3.4
ENV PYTHONUNBUFFERED 1
ENV WITH_DOCKER True
RUN mkdir /src
WORKDIR /src
ADD requirements.txt /src/
RUN pip install -r requirements.txt
ADD . /src/
