# Generated by Django 2.0.4 on 2018-04-29 03:50

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0005_profile_user'),
    ]

    operations = [
        migrations.AlterField(
            model_name='profile',
            name='url',
            field=models.CharField(blank=True, max_length=255, unique=True),
        ),
    ]
