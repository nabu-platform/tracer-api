A nabu agent: a separate process based on the same libraries but a different (not Standalone) runnable
	- monitor the underlying OS
	- process event logs that we get from the server (push them to cloud, store locally,...)
	- handoff socket for downtime page
	- have ability to restart nabu server etc?
-> this process can still function if the nabu server is dying for some reason

we want to get a full view of a single execution (either webbased or other)
	-> use correlation id to bring stuff together

correlation id is important!

-> bind together all the traces into a single call
-> same with alias, realm and other identifiers

The id is that we have at least two implementations in the beginning:

- one that transforms all the traces into event logs that we store


draw inspiration from:
- https://github.com/Dynatrace/OneAgent-SDK-for-Java
- https://github.com/Dynatrace/OneAgent-SDK#features