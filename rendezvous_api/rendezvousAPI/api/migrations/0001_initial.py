# Generated by Django 2.0.4 on 2018-04-29 05:26

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='Destination',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('train_stop', models.CharField(max_length=255)),
                ('lat', models.CharField(max_length=255)),
                ('long', models.CharField(max_length=255)),
                ('trains', models.CharField(max_length=255)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='Meetup',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('address', models.CharField(max_length=255)),
                ('lat', models.CharField(max_length=255)),
                ('long', models.CharField(max_length=255)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='Profile',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('url', models.CharField(blank=True, max_length=255, unique=True)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
                ('user', models.ForeignKey(default=1, on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL)),
            ],
        ),
        migrations.CreateModel(
            name='School',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255, unique=True)),
                ('domain', models.CharField(max_length=255)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='Trip',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('time', models.DateTimeField(default=None)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
                ('destination', models.ForeignKey(db_column='train_stop', on_delete=django.db.models.deletion.CASCADE, to='api.Destination')),
                ('meetup', models.ForeignKey(db_column='address', on_delete=django.db.models.deletion.CASCADE, to='api.Meetup')),
                ('users', models.ManyToManyField(to='api.Profile')),
            ],
        ),
        migrations.AddField(
            model_name='meetup',
            name='school',
            field=models.ForeignKey(db_column='name', on_delete=django.db.models.deletion.CASCADE, to='api.School'),
        ),
        migrations.AddField(
            model_name='destination',
            name='school',
            field=models.ForeignKey(db_column='name', on_delete=django.db.models.deletion.CASCADE, to='api.School'),
        ),
    ]
