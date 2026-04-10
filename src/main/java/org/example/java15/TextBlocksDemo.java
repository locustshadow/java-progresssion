package org.example.java15;

public class TextBlocksDemo {
    public static void main(String[] args) {
        var x = """
                    {
                        "login": "octocat",
                        "id": 583231,
                        "node_id": "MDQ6VXNlcjU4MzIzMQ==",
                        "avatar_url": "https://avatars.githubusercontent.com/u/583231?v=4",
                        "gravatar_id": "",
                        "url": "https://api.github.com/users/octocat",
                        "type": "User",
                        "user_view_type": "public",
                        "site_admin": false,
                        "name": "The Octocat",
                        "company": "@github",
                        "blog": "https://github.blog",
                        "location": "San Francisco",
                        "public_repos": 8,
                        "public_gists": 8,
                        "followers": 22222,
                        "following": 9,
                        "created_at": "2011-01-25T18:44:36Z",
                        "updated_at": "2026-03-22T11:23:02Z"
                    }
                """;
        System.out.println(x.indent(-4));
    }
}
