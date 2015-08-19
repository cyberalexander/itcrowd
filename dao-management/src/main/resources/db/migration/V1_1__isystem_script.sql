INSERT INTO `itcrowd`.`T_TOPICS` (`F_TOPIC_NAME`) VALUES ('Connection does not work');
INSERT INTO `itcrowd`.`T_TOPICS` (`F_TOPIC_NAME`) VALUES ('No connection signal');
INSERT INTO `itcrowd`.`T_TOPICS` (`F_TOPIC_NAME`) VALUES ('Bad connection signal');
INSERT INTO `itcrowd`.`T_TOPICS` (`F_TOPIC_NAME`) VALUES ('Periodic disconnections');
INSERT INTO `itcrowd`.`T_TOPICS` (`F_TOPIC_NAME`) VALUES ('Low data rate');


INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Not burn DSL light on the modem', '2015-08-18 21:37:26', '2015-08-18 21:37:26', 'Alexander Vysotskiy', '2');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Sites can not be opened, but the modem works as usual', '2015-08-18 21:38:26', '2015-08-18 21:38:26',  'Vladimir Kopylovskiy', '3');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('It does not start the connection, an error', '2015-08-14 21:39:26', '2015-08-18 21:39:26',  'Anderson Silva', '1');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Everything is set up according to the instructions, but the Internet is not working', '2015-08-18 21:40:26', '2015-08-13 21:40:26',  'Levon Blagidze', '2');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('In a local network installed several modems connected to different providers', '2015-08-18 21:41:26', '2015-08-13 21:42:26',  'Ketrin Finigun', '3');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Internet access is not', '2015-08-16 21:43:26', '2015-08-18 21:43:26',  'Samuel Jakson', '3');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('No Internet access when connected via modem port is blocked on the equipment provider', '2015-08-18 21:49:26', '2015-08-13 21:44:26',  'Katrin Deburson', '1');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('It works only ICQ, and (or) Skype - pages will not load', '2015-08-18 21:45:26', '2015-08-18 21:46:26',  'Emma Wattson', '1');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Have a problem with configuration of my application. Can`t see pictures on welcome page.', '2015-08-19 21:45:26', '2015-08-19 21:45:26',  'Hilary Stuff', '3');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Can`t load files from internet. Drop connection.', '2015-08-19 22:45:26', '2015-08-19 23:45:36',  'Jack Black', '4');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('This troubleshooting guide is designed to help you resolve common problems associated with embedding and configuring your JW Player setup.', '2015-08-19 21:55:26', '2015-08-19 21:59:26',  'Vladimir Urbancev', '5');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('If, after reading through this document, you are still unable to solve your issue, please post a question on this site. Include an example URL with your forum post, so we can take a look at your issue.', '2015-08-19 22:35:26', '2015-08-19 22:58:26',  'Klaus Dmitrov', '1');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Before looking into specific errors, we recommend you try the following simple steps, which may instantly fix your issue.', '2015-08-19 21:45:26', '2015-08-19 21:45:26',  'Jessicka Alba', '2');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('Error loading player: Flash version must be 11.2 or greater.', '2015-08-19 21:37:26', '2015-08-19 21:37:26', 'Alexander Vysotskiy', '2');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('This means the version of the Flash plugin on your computer is too outdated for JW Player to use.', '2015-08-19 22:37:26', '2015-08-19 22:38:26', 'Levon Blagidze', '4');
INSERT INTO `itcrowd`.`T_INQUIRIES` (`F_DESCRIPTION`, `F_CREATE_DATE`, `F_MODIFIED_WHEN`, `F_CUSTOMER_NAME`, `F_TOPIC_ID`)
VALUES ('This means the page with JW Player embedded is not loaded from a webserver. Due to various online-offline security restrictions, such a setup is not supported in the Flash rendering mode.', '2015-08-19 23:37:26', '2015-08-19 23:47:26', 'Anderson Silva', '2');



INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('1', 'address', 'Minsk city, Kirova str., 7');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('1', 'mobile phone', '+375 29 657-23-90');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('2', 'address', 'Minsk city, Karla Marksa str., 45');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('3', 'mobile phone', '+375 33 987-23-77');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('4', 'mobile phone', '+375 29 676-23-12');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('5', 'mobile phone', '+375 44 437-26-54');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('5', 'address', 'Minsk city, Varvasheni str., 45-89');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('6', 'mobile phone', '+375 29 980-23-54');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('7', 'address', 'Minsk city, Auezova str., 57-10');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('9', 'address', 'Minsk city, Kuleshova str., 190');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('11', 'mobile phone', '+375 25 888-53-22');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('11', 'address', 'Minsk city, Lubimova pr., 190-58');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('12', 'address', 'Minsk city, Mstislavskaia str., 110-111');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('13', 'address', 'Minsk city, Percovaia str., 8-1');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('14', 'mobile phone', '+375 44 190-89-12');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('15', 'mobile phone', '+375 25 646-09-17');
INSERT INTO `itcrowd`.`T_ATTRIBUTES_OF_INQUIRY` (`F_INQUIRY_ID`, `F_NAME`, `F_VALUE`)
VALUES ('15', 'address', 'Minsk city, Narochanskaia str., 89-91');


