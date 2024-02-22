# Specify Base Image
FROM node:18-alpine
 
# Work Directory
WORKDIR /usr/app

#copy files from folder to required directory
COPY ./ ./
 
# Install Dependencies
RUN npm install
 
# Startup Command
CMD ["npm", "start"]