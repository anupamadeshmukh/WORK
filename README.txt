Please read this before running the project.
1. Please install jdk 1.8, apache-activemq-5.8.0
2. Open the batch files and make sure that all the variables are pointing as per the local setup.
		buildTradeSale.cmd
		runProductSaleMessageProcessor.cmd
		runProductSaleMessageSender.cmd
		
3. EXECUTE buildTradeSale.cmd to build and package the project.
4. EXECUTE runProductSaleMessageProcessor.cmd is for running the message processor.
5. EXECUTE runProductSaleMessageSender.cmd for running the Mock Message Sender