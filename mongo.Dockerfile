FROM mongo
EXPOSE 27025
CMD [ "./run.sh" ]

COPY run.sh .

# CMD [ "mongod", "--bind_ip_all", "--port", "27020" ] for some reason running the container with CMD, and not through scipt requires the Candidates app to authenticate, but script does not need it.