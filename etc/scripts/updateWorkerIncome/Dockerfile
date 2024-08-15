# Use an official Python runtime as a parent image
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Install curl
RUN apt-get update && apt-get install -y curl

# Copy the current directory contents into the container at /usr/src/app
COPY .. .

# Run script.py when the container launches
CMD ["python", "script.py"]
