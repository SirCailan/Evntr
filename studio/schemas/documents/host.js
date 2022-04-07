export default {
    title: 'Host',
    name: 'host',
    type: 'document',
    fields: [
        {
            title: 'Name',
            name: 'name',
            type: 'string',
            description: 'Please use "Firstname Lastname" format',
        },
        {
            title: 'Image',
            name: 'image',
            type: 'image',
        },
        {
			title: 'Address',
			name: 'address',
			type: 'object',
			fields: [
				{
					name: 'street',
					description: 'Street name with door number',
					type: 'string',
				},
                {
                    name: 'city',
                    type: 'string'
                },
				{
					name: 'zip',
					type: 'number',
				}
			]
		}
    ]
}