-- Users (passwords are plaintext for testing)
INSERT INTO users (user_name, password)
VALUES ('alice', 'alice123');
INSERT INTO users (user_name, password)
VALUES ('bob', 'bob123');
INSERT INTO users (user_name, password)
VALUES ('charlie', 'charlie123');

-- Alice's journals (user_id = 1)
INSERT INTO journal (title, content, date, user_id)
VALUES ('Morning Reflections', 'Woke up early today and felt incredibly refreshed. The sunrise was beautiful.',
        '2024-01-01 07:30:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('First Day at Gym', 'Started my fitness journey today. Did 30 minutes of cardio and some light weights.',
        '2024-01-02 08:00:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Cooking Experiment', 'Tried making pasta from scratch today. It turned out better than expected!',
        '2024-01-03 18:45:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Reading Session', 'Finished the first chapter of Atomic Habits. So many insights about building good habits.',
        '2024-01-04 21:00:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Rainy Day Thoughts', 'It rained all day. Spent time indoors reflecting on my goals for the year.',
        '2024-01-05 14:00:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Weekend Hike', 'Went on a 5km trail with friends. Nature is truly the best stress reliever.',
        '2024-01-06 09:30:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Work Stress', 'Had a tough meeting today. Need to learn to manage stress better at work.',
        '2024-01-07 20:00:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Meditation Attempt', 'Tried meditating for 10 minutes before bed. It was harder than I thought.',
        '2024-01-08 22:00:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Gratitude List', 'Wrote down 10 things I am grateful for. Feeling much more positive now.',
        '2024-01-09 19:30:00', 1);
INSERT INTO journal (title, content, date, user_id)
VALUES ('New Project Kickoff', 'Started a new side project today. Excited to see where it goes in the coming weeks.',
        '2024-01-10 11:00:00', 1);

-- Bob's journals (user_id = 2)
INSERT INTO journal (title, content, date, user_id)
VALUES ('Travel Planning', 'Started planning a trip to Japan for spring. So many places to visit and things to eat.',
        '2024-01-01 10:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Guitar Practice', 'Practiced guitar for an hour today. Finally nailed the F chord after weeks of trying.',
        '2024-01-02 17:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Movie Night', 'Watched Inception again. Still as mind-bending as the first time I saw it years ago.',
        '2024-01-03 22:30:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Budget Review', 'Reviewed my monthly expenses. Need to cut back on eating out and random online shopping.',
        '2024-01-04 20:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Coffee Discovery', 'Found an amazing local coffee shop today. The pour-over was absolutely perfect.',
        '2024-01-05 09:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Photography Walk', 'Walked around downtown with my camera. Got some really great shots of the old buildings.',
        '2024-01-06 15:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Coding Challenge', 'Solved three LeetCode problems today. Medium difficulty but managed to crack them all.',
        '2024-01-07 13:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Family Call', 'Had a long video call with family. Miss them a lot. Planning to visit next month.',
        '2024-01-08 19:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Book Club Meeting',
        'Discussed The Alchemist with the book club. Great conversation about following your dreams.',
        '2024-01-09 18:00:00', 2);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Productivity Hack', 'Tried the Pomodoro technique for work today. Got so much more done than usual.',
        '2024-01-10 16:00:00', 2);

-- Charlie's journals (user_id = 3)
INSERT INTO journal (title, content, date, user_id)
VALUES ('Garden Update', 'Planted tomatoes and basil in the backyard today. Hope they grow well this season.',
        '2024-01-01 11:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Language Learning', 'Completed day 30 of my Spanish streak on Duolingo. Consistency is paying off slowly.',
        '2024-01-02 20:30:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Yoga Session', 'Did a 45 minute yoga flow this morning. My flexibility has improved a lot recently.',
        '2024-01-03 07:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Journaling Benefits',
        'Noticed that writing daily has helped me process emotions much more clearly these days.',
        '2024-01-04 22:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Volunteering Day',
        'Volunteered at the local food bank today. Very humbling and fulfilling experience overall.',
        '2024-01-05 16:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Art Project', 'Started a watercolor painting of the mountains. Still a beginner but enjoying the process.',
        '2024-01-06 14:30:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Sleep Schedule Fix', 'Going to bed at 10pm and waking at 6am. Energy levels are noticeably better now.',
        '2024-01-07 22:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Career Thoughts',
        'Thinking about switching careers into UX design. Need to research more and take some courses.',
        '2024-01-08 21:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Podcast Listening', 'Listened to a great episode about stoicism and modern life. Really made me think deeply.',
        '2024-01-09 12:00:00', 3);
INSERT INTO journal (title, content, date, user_id)
VALUES ('Monthly Review', 'Reviewed January goals. Hit 7 out of 10. Not perfect but proud of the progress made.',
        '2024-01-10 23:00:00', 3);