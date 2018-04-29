# Generated by Django 2.0.4 on 2018-04-29 03:45

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
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
                ('meetup', models.CharField(max_length=255)),
                ('destination', models.CharField(max_length=255)),
                ('time', models.DateTimeField(default=None)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=255, unique=True)),
                ('phone', models.IntegerField(unique=True)),
                ('email', models.EmailField(max_length=254, unique=True)),
                ('date_created', models.DateTimeField(auto_now_add=True)),
                ('date_modified', models.DateTimeField(auto_now=True)),
            ],
        ),
        migrations.AddField(
            model_name='trip',
            name='users',
            field=models.ManyToManyField(to='api.User'),
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
